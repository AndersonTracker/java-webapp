package com.sorveteria.servlets;

import java.util.List;

public interface DefaultServlet<T> {
    T doGet(int id);
    List<T> doGetAll();
	void doPost();
	void doPut(int id);
	void doDelete(int id);
}
