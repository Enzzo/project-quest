package ru.javarush.vasilev.quest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import ru.javarush.vasilev.quest.entity.Answer;
import ru.javarush.vasilev.quest.entity.SessionInfo;
import ru.javarush.vasilev.quest.service.QuestService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private QuestService questService = new QuestService();
    private SessionInfo session = new SessionInfo();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(getClientIpAddr(request));
        String name = request.getParameter("name");

        if(!StringUtils.isBlank(name)) {
            session.setUserName(name);
        }

        String param = request.getParameter("game");
        String idx = request.getParameter("idx");

        if(StringUtils.equals(param, "start")){
            questService.load(0);
        }
        if(StringUtils.isNumeric(idx)){
            questService.setNextQuestion(Integer.parseInt(idx));
        }

        String title = questService.getTitle();
        request.setAttribute("title", title);

        String text = questService.getText();
        request.setAttribute("text", text);

        List<Answer> answers = questService.getAnswers();
        request.setAttribute("answers", answers);

        getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        File file = new File(loader.getResource(".").getFile() + "/status.json");
        ObjectMapper mapper = new ObjectMapper();
        SessionInfo test = new SessionInfo();
        test.setUserName("username");

        try(FileWriter writer = new FileWriter("/status.json")){
            mapper.writeValue(writer, test);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}