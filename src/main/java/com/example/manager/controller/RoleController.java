package com.example.manager.controller;

import com.example.common.annotation.Log;
import com.example.common.controller.BaseController;
import com.example.common.entity.QueryRequest;
import com.example.common.entity.ResponseBo;
import com.example.manager.entity.Role;
import com.example.manager.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018/5/20 0020 20:43
 */
@Controller
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @Log("获取角色信息")
    @RequestMapping("role")
    @RequiresPermissions("role:list")
    public String index() {
        return "manager/role/role";
    }

    @RequestMapping("role/list")
    @ResponseBody
    public Map<String, Object> roleList(QueryRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> list = this.roleService.selectAll();
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @RequestMapping("role/getRole")
    @ResponseBody
    public ResponseBo getRole(Long roleId) {
        try {
            Role role = this.roleService.findRoleWithMenus(roleId);
            return ResponseBo.ok(role);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取角色信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("role/checkRoleName")
    @ResponseBody
    public boolean checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return true;
        }
        Role result = this.roleService.findByName(roleName);
        if (result != null)
            return false;
        return true;
    }

    @Log("新增角色")
    @RequiresPermissions("role:add")
    @RequestMapping("role/add")
    @ResponseBody
    public ResponseBo addRole(Role role, Long[] menuId) {
        try {
            this.roleService.addRole(role, menuId);
            return ResponseBo.ok("新增角色成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增角色失败，请联系网站管理员！");
        }
    }

    @Log("删除角色")
    @RequiresPermissions("role:delete")
    @RequestMapping("role/delete")
    @ResponseBody
    public ResponseBo deleteRoles(String ids) {
        try {
            this.roleService.deleteRoles(ids);
            return ResponseBo.ok("删除角色成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除角色失败，请联系网站管理员！");
        }
    }

    @Log("修改角色")
    @RequiresPermissions("role:update")
    @RequestMapping("role/update")
    @ResponseBody
    public ResponseBo updateRole(Role role, Long[] menuId) {
        try {
            this.roleService.updateRole(role, menuId);
            return ResponseBo.ok("修改角色成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改角色失败，请联系网站管理员！");
        }
    }
}
