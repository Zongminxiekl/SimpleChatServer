package cn.snowing.controller;

import cn.snowing.domain.User;
import cn.snowing.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    /**
     * 用户登录方法接口，传过来的应当是包含用户名和密码的User对象序列化的Json字符串
     * 方便浏览器测试，暂时不使用Json提交数据，要使用Json只需要User参数前加上注解@RequestBody
     * @param user
     * @return 返回的是一个loginUser， 包含用户的所有信息
     */
    @RequestMapping("/login")
    public @ResponseBody User login(@RequestBody User user){
        return userServices.login(user);
    }

    /**
     * 用户注册api接口，传过来的应当是包含nickname, username和password的User对象序列化的Json字符串
     * @return
     */
    @RequestMapping("/register")
    public @ResponseBody
    User register(@RequestBody User user){
        return userServices.register(user);
    }

    @RequestMapping("/searchUser")
    public @ResponseBody List<User> searchUser(String username){
        return userServices.searchUser(username);
    }


    @RequestMapping("/image/head")
    public @ResponseBody String getHead(@RequestParam("imageName") String imageName, HttpServletRequest request,
                                        HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url = session.getServletContext().getRealPath("/") + "images/head/" + imageName + ".png";
        System.out.println(url);
        File file = new File(url);

        byte[] img = new byte[0];
        if (file.exists()){
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                assert fis != null;
                img = toByteArray(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String commentUrl = session.getServletContext().getRealPath("/") + "images/head/"  + "comment.png";
            File file1 = new File(commentUrl);
            FileInputStream fis1 = null;
            try {
                fis1 = new FileInputStream(file1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                assert fis1 != null;
                img = toByteArray(fis1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // img为图片的二进制流
        response.setContentType("image/png");
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            os.write(img);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024*4];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
