package com.ipartek.formacion.supermercado.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.supermercado.modelos.Usuario;

public class UsuarioDaoTreeMap implements DaoUsuario<Usuario> {

	private static TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "javier@lete.com", "contra"));
		usuarios.put(2L, new Usuario(2L, "pepe@perez.com", "perez"));
		usuarios.put(3L, new Usuario(3L, "juan@juan.com", "juan"));
	}

	// SINGLETON
	private UsuarioDaoTreeMap() {
	}

	private static UsuarioDaoTreeMap INSTANCIA = new UsuarioDaoTreeMap();

	public static UsuarioDaoTreeMap getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public void crear(Usuario usuario) {
		Long id = usuarios.size() == 0 ? 1L : usuarios.lastKey() + 1L;
		usuario.setId(id);
		usuarios.put(id, usuario);

	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void eliminar(Long id) {
		usuarios.remove(id);

	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		for (Usuario usuario : usuarios.values()) {
			if (usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}

	// public Usuario obtenerPorEmail(String email) {
//		Usuario resultado = null;
//		
//		for(Usuario usuario: usuarios.values()) {
//			if(usuario.getEmail().equals(email)) {
//				resultado = usuario;
//				break;
//			}
//		}
//		
//		return resultado;
//	}

}
