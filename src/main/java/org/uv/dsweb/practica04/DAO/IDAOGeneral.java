/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dsweb.practica04.DAO;

import java.util.List;

/**
 *
 * @author juan
 */
public interface IDAOGeneral<T,ID> {
    public T save(T t);
    public boolean delete(ID id);
    public T update(T t, ID id);
    public T find(ID id);
    public List<T> findAll();
}
