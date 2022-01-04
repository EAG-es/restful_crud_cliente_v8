/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incli.restful.restful_crud_cliente.rest;

import incli.restful.Usar_ssls;
import static inser.persistence.restful_crud.PersistenceConfig.jdbc_contraseña;
import static inser.persistence.restful_crud.PersistenceConfig.jdbc_usuario;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ProductoFacadeREST
 * [inser.restful.restful_crud.producto]<br>
 * USAGE:
 * <pre>
 *        Producto client = new Producto();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author informatica
 */
public class Producto {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/restful_crud/webresources";
    private static final String BASE_URI_TLS = "https://localhost:8443/restful_crud/webresources";
    private static final String PATH = "inser.restful.restful_crud.producto";
    
    public Producto(String uri_base, String path) {
        Usar_ssls usar_ssls = new Usar_ssls();
        usar_ssls.evitar_excepcion_no_name_matching();
        client = javax.ws.rs.client.ClientBuilder.newBuilder().sslContext(Usar_ssls.getSSLContext()).build();
        webTarget = client.target(uri_base).path(path);
    }

    public Producto(String uri_base) {
        this(uri_base, PATH);
    }
    
    public Producto() {
        this(BASE_URI_TLS, PATH);
    }
    
    public Long countREST(String usuario, String contraseña, String [] error) throws ClientErrorException {
        Long retorno;
        Response response;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path("count");
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN);
        response = builder.get();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            retorno = null;
        } else {
            retorno = Long.valueOf(response.readEntity(String.class));
        }
        return retorno;
    }

    public boolean edit_JSON(Object requestEntity, String id, String usuario, String contraseña, String [] error) throws ClientErrorException {
        boolean ret = true;
        Response response;
        javax.ws.rs.client.Entity entity;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        entity = javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.put(entity);
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            ret = false;
        }
        return ret;
    }

    public <T> T find_JSON(Class<T> responseType, String id, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.get();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.get();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public boolean create_JSON(Object requestEntity, String usuario, String contraseña, String [] error) throws ClientErrorException {
        boolean ret = true;
        Response response;
        javax.ws.rs.client.Entity entity;
        int status;
        WebTarget resource = webTarget;
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        entity = javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.post(entity);
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            ret = false;
        }
        return ret;
    }

    public <T> T findAll_JSON(Class<T> responseType, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.get();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public <T> T findLike_descripcion_JSON(Class<T> responseType, String from, String to, String descripcion, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        javax.ws.rs.client.Entity entity;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        entity = javax.ws.rs.client.Entity.entity(descripcion, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.post(entity);
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public <T> T findLike_descripcion_orden_JSON(Class<T> responseType, String from, String to, String descripcion, String campo_ordenacion, String asc, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        javax.ws.rs.client.Entity entity;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}/{2}/{3}", new Object[]{from, to, campo_ordenacion, asc}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        entity = javax.ws.rs.client.Entity.entity(descripcion, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.post(entity);
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public <T> T find_orden_JSON(Class<T> responseType, String from, String to, String campo_ordenacion, String asc, String usuario, String contraseña, String [] error) throws ClientErrorException {
        Response response;
        T t = null;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}/{2}/{3}", new Object[]{from, to, campo_ordenacion, asc}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        builder = builder.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        response = builder.get();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            t = null;
        } else {
            t = response.readEntity(responseType);
        }
        return t;
    }

    public boolean remove(String id, String usuario, String contraseña, String [] error) throws ClientErrorException {
        boolean ret = true;
        Response response;
        int status;
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        Builder builder = resource.request();
        MultivaluedMap<String, Object> multivaluedMap = new MultivaluedHashMap();
        multivaluedMap.add(jdbc_usuario, usuario);
        multivaluedMap.add(jdbc_contraseña, contraseña);
        builder = builder.headers(multivaluedMap);
        response = builder.delete();
        status = response.getStatus();
        if (status < 200 || status >= 300) {
            error[0] = response.readEntity(String.class);
            ret  = false;
        }
        return ret;
    }

    public void close() {
        client.close();
    }
    
}
