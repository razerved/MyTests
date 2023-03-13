package qa.rest;

import java.util.ArrayList;

public class Root  {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<Data> data;
    private String url;
    private String text;

    private String email;
    private String password;
    public Root() {
    }
    public Root(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Root(Integer page, Integer per_page, Integer total,
                Integer total_pages, ArrayList<Data> data, String url, String text) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.url = url;
        this.text = text;
    }


    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public String getSupport() {
        return url;
    }
    public String getText(){
        return text;
    }

}
