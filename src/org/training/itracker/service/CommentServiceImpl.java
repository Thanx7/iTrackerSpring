package org.training.itracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.itracker.beans.Comment;
import org.training.itracker.dao.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Transactional
	public void saveComment(Comment comment) {
		commentDAO.saveComment(comment);
	}
}