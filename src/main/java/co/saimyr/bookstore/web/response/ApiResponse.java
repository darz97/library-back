package co.saimyr.bookstore.web.response;

import co.saimyr.bookstore.transversal.enumeration.ResponseStateEnum;

import java.util.List;

public class ApiResponse <T>{
    private List<T> data;
    private List<String> message;
    private ResponseStateEnum state;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public ResponseStateEnum getState() {
        return state;
    }

    public void setState(ResponseStateEnum state) {
        this.state = state;
    }
}
