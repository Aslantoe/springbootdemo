package com.example.manager.controller;

import com.example.common.annotation.Log;
import com.example.common.controller.BaseController;
import com.example.common.entity.ResponseBo;
import com.example.common.entity.Tree;
import com.example.manager.entity.Permission;
import com.example.manager.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jack
 * @date 2018/5/20 0020 21:10
 */
@Controller
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @Log("获取菜单信息")
    @RequestMapping("menu")
    @RequiresPermissions("menu:list")
    public String index() {
        return "manager/menu/menu";
    }


    @RequestMapping("menu/menu")
    @ResponseBody
    public ResponseBo getMenu(String userName) {
        try {
            List<Permission> permissions = this.permissionService.findUserPermissions(userName);
            return ResponseBo.ok(permissions);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("獲取菜單失敗！");
        }
    }

    @RequestMapping("menu/getMenu")
    @ResponseBody
    public ResponseBo getMenu(Long menuId) {
        try {
            Permission menu = this.permissionService.findById(menuId);
            return ResponseBo.ok(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取信息失败，请联系网站管理员！");
        }
    }

    @RequestMapping("menu/menuButtonTree")
    @ResponseBody
    public ResponseBo getMenuButtonTree() {
        try {
            Tree<Permission> tree = this.permissionService.getMenuButtonTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单列表失败！");
        }
    }

    @RequestMapping("menu/tree")
    @ResponseBody
    public ResponseBo getMenuTree() {
        try {
            Tree<Permission> tree = this.permissionService.getMenuTree();
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取菜单列表失败！");
        }
    }

    @RequestMapping("menu/getUserMenu")
    @ResponseBody
    public ResponseBo getUserMenu(String userName) {
        try {
            Tree<Permission> tree = this.permissionService.getUserMenu(userName);
            return ResponseBo.ok(tree);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("获取用户菜单失败！");
        }
    }

    @RequestMapping("menu/list")
    @ResponseBody
    public List<Permission> menuList(Permission menu) {
        try {
            return this.permissionService.findAllMenus(menu);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @RequestMapping("menu/checkMenuName")
    @ResponseBody
    public boolean checkMenuName(String menuName, String type, String oldMenuName) {
        if (StringUtils.isNotBlank(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
            return true;
        }
        Permission result = this.permissionService.findByNameAndType(menuName, type);
        if (result != null)
            return false;
        return true;
    }

    @Log("新增菜单/按钮")
    @RequiresPermissions("menu:add")
    @RequestMapping("menu/add")
    @ResponseBody
    public ResponseBo addMenu(Permission menu) {
        String name = "";
        if (Permission.TYPE_MENU.equals(menu.getType())) {
            name = "菜单";
        }else {
            name = "按钮";
        }
        try {
            this.permissionService.addMenu(menu);
            return ResponseBo.ok("新增" + name + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("新增" + name + "失败，请联系网站管理员！");
        }
    }

    @Log("删除菜单")
    @RequiresPermissions("menu:delete")
    @RequestMapping("menu/delete")
    @ResponseBody
    public ResponseBo deleteMenus(String ids) {
        try {
            this.permissionService.deleteMeuns(ids);
            return ResponseBo.ok("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("删除失败，请联系网站管理员！");
        }
    }

    @Log("修改菜单/按钮")
    @RequiresPermissions("menu:update")
    @RequestMapping("menu/update")
    @ResponseBody
    public ResponseBo updateMenu(Permission menu) {
        String name = "";
        if (Permission.TYPE_MENU.equals(menu.getType())) {
            name = "菜单";
        }else {
            name = "按钮";
        }
        try {
            this.permissionService.updateMenu(menu);
            return ResponseBo.ok("修改" + name + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("修改" + name + "失败，请联系网站管理员！");
        }
    }
}
