package com.vteba.logger.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试logger
 * 
 * @author yinlei
 * @date 2016年3月15日 下午4:32:58
 */
@WebServlet(name = "logger", urlPatterns = {"/logger"})
public class LoggerServlet extends HttpServlet {
	private static final long serialVersionUID = 3808416677818143722L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.debug("debug的");
		LOGGER.info("info的");
		LOGGER.warn("warn的");
		LOGGER.error("error的");
		String a = null;
		try {
			if (a == null) {
				throw new NullPointerException("控制正异常。");
			}
		} catch (Exception e) {
			LOGGER.info("info测试", e);// Exception会打出来，普通参数不会，见下一个
			LOGGER.info("info test2", "真是2");// 第二个参数打不出来
			LOGGER.info("info test2, msg=[{}]", "真是2");// 这个才是对的，要使用占位符
			LOGGER.error("错误了=[{}][{}]", "shi", "dangdang", e);
			LOGGER.error("错误了=[{}][{}]看异常是否会占位", "shi", e);// 会将e作为一个参数放到占位符中
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
