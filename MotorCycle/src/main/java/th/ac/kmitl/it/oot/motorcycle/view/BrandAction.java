package th.ac.kmitl.it.oot.motorcycle.view;

import com.opensymphony.xwork2.ActionSupport;

import th.ac.kmitl.it.oot.motorcycle.model.Brand;

public class BrandAction extends ActionSupport {
    private Brand brand;
    public String execute() {
        brand = new Brand();
        return SUCCESS;
    }
    public Brand getBrand() {
        return this.brand;
    }
    public String getAction() {
        return this.action;
    }
}