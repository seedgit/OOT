package th.ac.kmitl.it.oot.motorcycle.view;

import com.opensymphony.xwork2.ActionSupport;

import th.ac.kmitl.it.oot.motorcycle.model.Brand;

public class IndexAction extends ActionSupport {
    private Brand objBrand;
    public String execute() {
        objBrand = new Brand();
        return SUCCESS;
    }
    public Brand getBrand() {
        return objBrand;
    }
}