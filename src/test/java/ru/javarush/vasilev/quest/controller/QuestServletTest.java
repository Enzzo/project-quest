package ru.javarush.vasilev.quest.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestServletTest {
    private QuestServlet        servlet;
    private HttpServletRequest  request;
    private HttpServletResponse response;
    private HttpSession         session;
    private ServletContext      servletContext;
    private ServletConfig       servletConfig;
    private RequestDispatcher   requestDispatcher;

    @BeforeEach
    void setUp()throws ServletException {
        servlet         = new QuestServlet();

        request         = Mockito.mock(HttpServletRequest.class);
        response        = Mockito.mock(HttpServletResponse.class);
        servletContext  = Mockito.mock(ServletContext.class);
        servletConfig   = Mockito.mock(ServletConfig.class);
        session         = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        servlet.init(servletConfig);
    }

    @Test
    void doGetTest() throws IOException, ServletException {

        servlet.doGet(request, response);
        requestDispatcher.forward(request, response);
        verify(request, times(3)).getParameter(Mockito.anyString());
    }
}