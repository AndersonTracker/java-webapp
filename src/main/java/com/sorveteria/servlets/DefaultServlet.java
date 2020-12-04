package com.sorveteria.servlets;

import java.util.List;

public interface DefaultServlet<T> {
    T doGet(int id);
    List<T> doGetAll();
	void doPost(String body);
	void doPut(int id, String body);
	void doDelete(int id);
}
