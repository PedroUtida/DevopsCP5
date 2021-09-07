package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.MovimentacaoDao;
import br.com.fiap.tds.entity.Movimentacao;

public class MovimentacaoDaoImpl extends GenericDaoImpl<Movimentacao, Integer>
				implements MovimentacaoDao{

	public MovimentacaoDaoImpl(EntityManager em) {
		super(em);
	}

}
