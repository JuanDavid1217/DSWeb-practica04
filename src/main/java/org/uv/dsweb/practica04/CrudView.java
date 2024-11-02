/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
/*package org.uv.dsweb.practica04;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.uv.dsweb.practica04.DAO.UserDAO;
import org.uv.dsweb.practica04.Entyties.User;

/**
 *
 * @author juan
 */
/*@Named(value = "crudView")
@SessionScoped
public class CrudView implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<User> users;

    private User selectedUser;

    private List<User> selectedUsers;

    private UserDAO userService;

    public CrudView() {
        this.userService = new UserDAO();
        this.users = this.userService.findAll();
        this.selectedUsers = new ArrayList<User>();
    }

    public List<User> getUsers() {
        this.users = this.userService.findAll();
        return this.users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public void openNew() {
        this.selectedUser = new User();
    }

    public void saveUser() {
        if(this.selectedUser.getId()== 0){
            this.userService.save(this.selectedUser);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            this.userService.update(this.selectedUser, this.selectedUser.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteUser() {
        this.users.remove(this.selectedUser);
        this.userService.delete(this.selectedUser.getId());
        this.selectedUsers.remove(this.selectedUser);
        this.selectedUser = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        /*if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }*/

/*        return "Delete";
    }

    public boolean hasSelectedUsers() {
        return this.selectedUsers != null && !this.selectedUsers.isEmpty();
    }

    public void deleteSelectedUsers() {
        this.users.removeAll(this.selectedUsers);
        for(User item:this.selectedUsers){
            this.userService.delete(item.getId());
        }
        this.selectedUsers = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }
    
}*/
