package com.codecool.web.servlet;

import com.codecool.web.model.User;
import com.codecool.web.model.UserList;
import com.codecool.web.service.EmailService;
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
    private EmailService es = new EmailService();


    public List<User> getUserList(){
        return userList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String isMentor = req.getParameter("type");
        if(password1.equals(password2)) {
            UserList.getInstance().addUser(new User(name, email, password1, password2, isMentor));
            resp.sendRedirect("login.html");
            save();
            //es.sendEmail();
        }else{
            req.setAttribute("error", "error");
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        RegisterServlet rs = new RegisterServlet();
        Serializer ser = new Serializer();
        ser.readSer();
    }
}
