package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.service.Serializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private List<User> userList = new ArrayList<>();
    private Serializer serializer = new Serializer();


    public List<User> getUserList(){
        return userList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String isMentor = req.getParameter("type");
        userList.add(new User("test@test.com", "test", "Q12345678x", "Q12345678x", "MENTOR"));
        User testUser = userList.get(0);
        if(testUser.getPassword().equals(testUser.getPassword2())) {
            userList.add(new User(name, email, password1, password2, isMentor));
            resp.sendRedirect("login.html");
        }else{
            req.setAttribute("error", "error");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    public void save() {
        try{
            serializer.saveUser(userList);
            System.out.println("User saved.");
        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    /*public void add(){
        userList.add(new User("test", "test@test.hu", "Q12345678x", "MENTOR"));
    }*/

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RegisterServlet rs = new RegisterServlet();
        Serializer ser = new Serializer();
        ser.readSer();
    }
}
