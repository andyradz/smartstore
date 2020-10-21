//package com.codigo.smartstore.webapi.services;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.SessionScope;
//
///// <summary>
///// News service interface
///// </summary>
//@Service
//@SessionScope
//public interface INewsService {
//	/// <summary>
//	/// Deletes a news
//	/// </summary>
//	/// <param name="newsItem">News item</param>
//	void deleteNews(NewsItem newsItem);
//
//	/// <summary>
//	/// Gets a news
//	/// </summary>
//	/// <param name="newsId">The news identifier</param>
//	/// <returns>News</returns>
//	NewsItem getNewsById(int newsId);
//
//	/// <summary>
//	/// Get news by identifiers
//	/// </summary>
//	/// <param name="newsIds">News identifiers</param>
//	/// <returns>News query</returns>
//	IQueryable<NewsItem> getNewsByIds(int[] newsIds);
//
//	/// <summary>
//	/// Gets all news
//	/// </summary>
//	/// <param name="languageId">Language identifier; 0 if you want to get all
//	/// records</param>
//	/// <param name="storeId">Store identifier; 0 if you want to get all
//	/// records</param>
//	/// <param name="pageIndex">Page index</param>
//	/// <param name="pageSize">Page size</param>
//	/// <param name="showHidden">A value indicating whether to show hidden
//	/// records</param>
//	/// <param name="maxAge">The maximum age of returned news</param>
//	/// <returns>News items</returns>
//	PageList<NewsItem> getAllNews(int languageId, int storeId, int pageIndex, int pageSize, boolean showHidden = false, DateTime? maxAge = null);
//
//	/**
//	 * Inserts a news item
//	 * 
//	 * @param news News item
//	 */
//	void insertNews(NewsItem news);
//
//	/**
//	 * Updates the news item
//	 * 
//	 * @param news News item
//	 */
//	void updateNews(NewsItem news);
//
//	/**
//	 * Update news item comment totals
//	 * 
//	 * @param newsItem News item
//	 */
//	void updateCommentTotals(NewsItem newsItem);
//}
