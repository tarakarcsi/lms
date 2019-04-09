package com.codecool.web.servlet;

import com.codecool.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList(){
        return userList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String isMentor = req.getParameter("type");

        userList.add(new User(name, email, password, isMentor));
    }

    public void saveUser() throws IOException{
        FileOutputStream foS = new FileOutputStream("./users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(foS);
        oos.writeObject(userList);
        oos.close();
        foS.close();
    }

    public void save() {
        try{
            saveUser();
            System.out.println("User saved.");
        }catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    public static void main(String[] args) {

        RegisterServlet rs = new RegisterServlet();
        rs.save();

    }
}
