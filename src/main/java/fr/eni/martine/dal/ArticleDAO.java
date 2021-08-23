package fr.eni.martine.dal;

import java.time.LocalDateTime;

import fr.eni.martine.bo.Article;
import fr.eni.martine.bo.User;

public interface ArticleDAO {

	
	public void CreateArticle(Article articleAVendre) throws DalException;

	
	
}
