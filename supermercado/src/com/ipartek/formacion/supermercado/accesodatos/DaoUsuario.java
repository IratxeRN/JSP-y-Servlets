package com.ipartek.formacion.supermercado.accesodatos;

public interface DaoUsuario<T> extends Dao<T> {

	T obtenerPorEmail(String email);

}
