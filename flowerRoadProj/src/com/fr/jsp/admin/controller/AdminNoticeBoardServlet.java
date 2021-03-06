package com.fr.jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fr.jsp.board.model.service.FaqBoardService;
import com.fr.jsp.board.model.service.NoticeBoardService;
import com.fr.jsp.board.model.service.ReviewBoardService;
import com.fr.jsp.board.model.service.UserQuestionBoardService;
import com.fr.jsp.board.model.vo.NoticeBoard;

@WebServlet("/noticeBoard.admin")
public class AdminNoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminNoticeBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FaqBoardService fbs = new FaqBoardService();
		// 전체 FAQ 게시판 게시글 수
		int admin_faqBoardCount = fbs.admin_faqBoardAllList().size();
		// Connection close
		fbs.closeCon();
		
		NoticeBoardService nbs = new NoticeBoardService();
		// 전체 공지사항 게시판 게시글 수
		int admin_noticeBoardCount = nbs.admin_noticeBoardAllCount();
		// 공지사항 게시판 리스트
		ArrayList<NoticeBoard> admin_noticeBoardList = nbs.admin_noticeBoardList();
		// Connection close
		nbs.closeCon();
		
		ReviewBoardService rbs = new ReviewBoardService();
		// 전체 리뷰 게시판 게시글 수
		int admin_reviewBoardCount = rbs.admin_reviewBoardAllCount();
		// Connection close
		rbs.closeCon();
		
		UserQuestionBoardService uqbs = new UserQuestionBoardService();
		// 전체 1:1 게시판 게시글 수
		int admin_userQuestionBoardCount = uqbs.admin_userQuestionBoardAllCount();
		// Connection close
		uqbs.closeCon();
		
		request.setAttribute("admin_faqBoardCount", admin_faqBoardCount);
		request.setAttribute("admin_noticeBoardCount", admin_noticeBoardCount);
		request.setAttribute("admin_noticeBoardList", admin_noticeBoardList);
		request.setAttribute("admin_reviewBoardCount", admin_reviewBoardCount);
		request.setAttribute("admin_userQuestionBoardCount", admin_userQuestionBoardCount);
		
		request.getRequestDispatcher("views/admin_views/admin_NoticeBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
