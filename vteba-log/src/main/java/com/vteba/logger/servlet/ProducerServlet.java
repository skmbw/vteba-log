package com.vteba.logger.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.vteba.batch.user.model.User;
import com.vteba.mq.rocketmq.producer.RocketMQMessageProducer;
import com.vteba.web.servlet.AutowiredHttpServlet;

/**
 * 测试生产者
 * 
 * @author yinlei
 * @date 2016年3月15日 下午4:32:58
 */
@WebServlet(name = "producer", urlPatterns = {"/producer"})
public class ProducerServlet extends AutowiredHttpServlet {
	private static final long serialVersionUID = 3808416677818143722L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServlet.class);
	
	@Inject
	private RocketMQMessageProducer rocketMQMessageProducer;
	
	@Override
	public void servlet(HttpServletRequest request, HttpServletResponse response) {
		
		User model = new User();
		model.setId(21);
		
		try {
			SendResult result = rocketMQMessageProducer.send(model);
			LOGGER.info("发送结果1：{}", result);
			
			model.setId(22);
			result = rocketMQMessageProducer.send("YinleiUser2", "Test2", model);
			LOGGER.info("发送结果2：{}", result);
			
			result = rocketMQMessageProducer.send(model);
			LOGGER.info("发送结果3：{}", result);
			
			model.setAge(19);
			model.setId(2);
			model.setName("Yinlei.Test2");
			result = rocketMQMessageProducer.send("Test1", model);
			LOGGER.info("发送结果4：{}", result);
			
			model.setId(3);
			model.setAge(20);
			model.setName("YinleiUser2.Test2");
			result = rocketMQMessageProducer.send("YinleiUser2", "Test2", model);
			LOGGER.info("发送结果5：{}", result);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			LOGGER.error("ServletException ", e);
		} catch (IOException e) {
			LOGGER.error("IOException ", e);
		}
		
	}

}
