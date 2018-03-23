package edu.wyu.dao;


import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

//import com.sammy.basic.dao.IBaseDao;
//import com.sammy.basic.model.Pager;
//import com.sammy.basic.model.SystemContext;
@SuppressWarnings("unchecked")
public class BaseDao<T>{

    private SessionFactory sessionFactory;
    /**
     * 创建一个Class的对象来获取泛型的class
     */
    private Class<?> clz;

    public Class<?> getClz() {
        if(clz==null) {
            //获取泛型的Class对象
            clz = ((Class<?>)
                    (((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Inject
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public T add(T t) {
        getSession().save(t);
        getSession().flush();
        return t;
    }


    public void update(T t) {
        getSession().update(t);
        getSession().flush();
    }

    public void delete(Serializable id) {
        getSession().delete(this.load(id));
        getSession().flush();
    }

    public void delete(T t) {
        getSession().delete(t);
        getSession().flush();
    }

    public T load(Serializable id) {
        if(null == id) {
            throw new RuntimeException("您查找的[" + id + "]不能为空！");
        }
        return (T) getSession().get(this.getClz(), id);

    }

    public List<T> list(String hql, Object... args) {
        return this.list(hql, args, null, null);
    }

//    public List<T> list(String hql, Object[] args) {
//        return this.list(hql, args, null, null);
//    }

    public List<T> list(String hql, Object[] args, LinkedHashMap<String, String> orderBy) {
        return this.list(hql, args, null, orderBy);
    }

    public List<T> list(String hql, Object arg) {
        return this.list(hql, new Object[]{arg});
    }

    public List<T> list(String hql) {
        return this.list(hql,null);
    }

    //组织查询排序条件
    public String bulidOrderBy(LinkedHashMap<String, String> orderBy) {
        StringBuffer buffer = new StringBuffer("");
        if (null != orderBy && !orderBy.isEmpty()) {
            buffer.append(" order by ");
            for(Entry<String, String> entry : orderBy.entrySet()) {
                buffer.append(entry.getKey() + " " + entry.getValue() + ",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }

    @SuppressWarnings("rawtypes")
    private void setAliasParameter(Query query,Map<String,Object> alias) {
        if(alias!=null) {
            Set<String> keys = alias.keySet();
            for(String key:keys) {
                Object val = alias.get(key);
                if(val instanceof Collection) {
                    //查询条件是列表
                    query.setParameterList(key, (Collection)val);
                } else {
                    query.setParameter(key, val);
                }
            }
        }
    }

    private void setParameter(Query query,Object[] args) {
        if(args!=null&&args.length>0) {
            int index = 0;
            for(Object arg:args) {
                query.setParameter(index++, arg);
            }
        }
    }

    public List<T> list(String hql, Object[] args, Map<String, Object> alias, LinkedHashMap<String, String> orderBy) {
        hql += bulidOrderBy(orderBy);
        Query query = getSession().createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        return query.list();
    }

    public List<T> listByAlias(String hql, Map<String, Object> alias) {
        return this.list(hql, null, alias, null);
    }

//    public Pager<T> find(String hql, Object[] args) {
//        return this.find(hql, args, null, null);
//    }
//
//    public Pager<T> find(String hql, Object[] args, LinkedHashMap<String, String> orderBy) {
//        return this.find(hql, args, null, orderBy);
//    }
//
//    public Pager<T> find(String hql, Object arg) {
//        return this.find(hql, new Object[]{arg});
//    }
//
//    public Pager<T> find(String hql) {
//        return this.find(hql,null);
//    }

//    @SuppressWarnings("rawtypes")
//    private void setPagers(Query query,Pager pages) {
//        Integer pageSize = SystemContext.getPageSize();
//        Integer pageOffset = SystemContext.getPageOffset();
//        if(pageOffset==null||pageOffset<0) pageOffset = 0;
//        if(pageSize==null||pageSize<0) pageSize = 15;
//        pages.setOffset(pageOffset);
//        pages.setSize(pageSize);
//        query.setFirstResult(pageOffset).setMaxResults(pageSize);
//    }

    private String getCountHql(String hql,boolean isHql) {
        String e = hql.substring(hql.indexOf("from"));
        String c = "select count(*) "+e;
        if(isHql)
            c = c.replaceAll("fetch", "");
        return c;
    }

//    public Pager<T> find(String hql, Object[] args, Map<String, Object> alias, LinkedHashMap<String, String> orderBy) {
//        hql += bulidOrderBy(orderBy);
//        String cq = getCountHql(hql,true);
//        Query cquery = getSession().createQuery(cq);
//        Query query = getSession().createQuery(hql);
//        //设置别名参数
//        setAliasParameter(query, alias);
//        setAliasParameter(cquery, alias);
//        //设置参数
//        setParameter(query, args);
//        setParameter(cquery, args);
//        Pager<T> pages = new Pager<T>();
//        setPagers(query,pages);
//        List<T> datas = query.list();
//        pages.setDatas(datas);
//        long total = (Long)cquery.uniqueResult();
//        pages.setTotal(total);
//        return pages;
//    }
//
//    public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
//        return this.find(hql,null, alias, null);
//    }

    public Object queryObject(String hql, Object[] args) {
        return this.queryObject(hql, args,null);
    }

    public Object queryObject(String hql, Object arg) {
        return this.queryObject(hql, new Object[]{arg});
    }

    public Object queryObject(String hql) {
        return this.queryObject(hql,null);
    }

    public void updateByHql(String hql, Object[] args) {
        Query query = getSession().createQuery(hql);
        setParameter(query, args);
        query.executeUpdate();
    }

    public void updateByHql(String hql, Object arg) {
        this.updateByHql(hql,new Object[]{arg});
    }

    public void updateByHql(String hql) {
        this.updateByHql(hql,null);
    }

    public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,
                                               boolean hasEntity) {
        return this.listBySql(sql, args, null, clz, hasEntity, null);
    }

    public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,
                                               boolean hasEntity) {
        return this.listBySql(sql, new Object[]{arg}, clz, hasEntity);
    }

    public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, null, clz, hasEntity);
    }

    public <N extends Object>List<N> listBySql(String sql, Object[] args,
                                               Map<String, Object> alias, Class<?> clz, boolean hasEntity, LinkedHashMap<String, String> orderBy) {
        sql += bulidOrderBy(orderBy);
        SQLQuery sq = getSession().createSQLQuery(sql);
        setAliasParameter(sq, alias);
        setParameter(sq, args);
        if(hasEntity) {
            sq.addEntity(clz);
        } else
            sq.setResultTransformer(Transformers.aliasToBean(clz));
        return sq.list();
    }

    public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,
                                                    Class<?> clz, boolean hasEntity) {
        return this.listBySql(sql, null, alias, clz, hasEntity, null);
    }

//    public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,
//                                                boolean hasEntity) {
//        return this.findBySql(sql, args, null, clz, hasEntity, null);
//    }
//
//    public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,
//                                                boolean hasEntity) {
//        return this.findBySql(sql, new Object[]{arg}, clz, hasEntity);
//    }
//
//    public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity) {
//        return this.findBySql(sql, null, clz, hasEntity);
//    }
//
//    public <N extends Object>Pager<N> findBySql(String sql, Object[] args,
//                                                Map<String, Object> alias, Class<?> clz, boolean hasEntity, LinkedHashMap<String, String> orderBy) {
//        sql += bulidOrderBy(orderBy);
//        String cq = getCountHql(sql,false);
//        SQLQuery sq = getSession().createSQLQuery(sql);
//        SQLQuery cquery = getSession().createSQLQuery(cq);
//        setAliasParameter(sq, alias);
//        setAliasParameter(cquery, alias);
//        setParameter(sq, args);
//        setParameter(cquery, args);
//        Pager<N> pages = new Pager<N>();
//        setPagers(sq, pages);
//        if(hasEntity) {
//            sq.addEntity(clz);
//        } else {
//            sq.setResultTransformer(Transformers.aliasToBean(clz));
//        }
//        List<N> datas = sq.list();
//        pages.setDatas(datas);
//        long total = ((BigInteger)cquery.uniqueResult()).longValue();
//        pages.setTotal(total);
//        return pages;
//    }
//
//    public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,
//                                                     Class<?> clz, boolean hasEntity) {
//        return this.findBySql(sql, null, alias, clz, hasEntity, null);
//    }

    public Object queryObject(String hql, Object[] args,
                              Map<String, Object> alias) {
        Query query = getSession().createQuery(hql);
        setAliasParameter(query, alias);
        setParameter(query, args);
        return query.list();
    }

    public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
        return this.queryObject(hql,null,alias);
    }

}
