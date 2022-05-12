package com.example.hrmsbackend.core.business.abstracts;

import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseManager<TEntityDao extends JpaRepository<TEntity, TEntityId>, TEntity, TEntityId>
		implements BaseService<TEntity, TEntityId> {
	private final TEntityDao entityDao;
	private final String entityName;

	public BaseManager(final TEntityDao tEntityDao, final String entityName) {
		this.entityDao = tEntityDao;
		this.entityName = entityName;
	}

	@Override
	public Result add(final TEntity entity) {
		entityDao.save(entity);
		return new SuccessResult(Messages.added(entityName));
	}

	@Override
	public Result delete(final TEntityId id) {
		final Optional<TEntity> entity = entityDao.findById(id);
		if (entity.isPresent()) {
			entityDao.delete(entity.get());
			return new SuccessResult(Messages.deleted(entityName));
		} else {
			return new ErrorDataResult<TEntity>(Messages.notFound(entityName));
		}

	}

	@Override
	public DataResult<List<TEntity>> getAll() {
		final List<TEntity> entities = entityDao.findAll();
		return new SuccessDataResult<List<TEntity>>(entities);
	}

	@Override
	public DataResult<TEntity> getById(final TEntityId id) {
		final Optional<TEntity> entity = entityDao.findById(id);

		if (entity.isEmpty())
			return new ErrorDataResult<TEntity>(Messages.notFound(entityName));

		return new SuccessDataResult<TEntity>(entity.get());
	}

	@Override
	public Result update(final TEntity entity) {
		entityDao.save(entity);
		return new SuccessResult(Messages.updated(entityName));
	}
}
