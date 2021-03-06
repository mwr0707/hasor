/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.core;
import java.util.List;
/**
 * Hasor的核心接口，它为应用程序提供了一个统一的配置界面和运行环境。
 * @version : 2013-3-26
 * @author 赵永春 (zyc@hasor.net)
 */
public class AppContextWarp implements AppContext {
    private Provider<AppContext> appContextProvider;
    private AppContext           appContext;
    //
    public AppContextWarp(AppContext appContext) {
        this.appContext = appContext;
    }
    public AppContextWarp(Provider<AppContext> appContextProvider) {
        this.appContextProvider = appContextProvider;
    }
    //
    public AppContext getAppContext() {
        if (this.appContext != null) {
            return this.appContext;
        }
        if (this.appContextProvider != null) {
            return this.appContextProvider.get();
        }
        return null;
    }
    //
    @Override
    public Environment getEnvironment() {
        return this.getAppContext().getEnvironment();
    }
    @Override
    public ClassLoader getClassLoader() {
        return this.getAppContext().getClassLoader();
    }
    @Override
    public void start(Module... modules) throws Throwable {
        this.getAppContext().start(modules);
    }
    @Override
    public boolean isStart() {
        return this.getAppContext().isStart();
    }
    @Override
    public void shutdown() {
        this.getAppContext().shutdown();
    }
    @Override
    public Class<?> getBeanType(String bindID) {
        return this.getAppContext().getBeanType(bindID);
    }
    @Override
    public String[] getBindIDs() {
        return this.getAppContext().getBindIDs();
    }
    @Override
    public String[] getNames(Class<?> targetClass) {
        return this.getAppContext().getNames(targetClass);
    }
    @Override
    public boolean containsBindID(String bindID) {
        return this.getAppContext().containsBindID(bindID);
    }
    @Override
    public <T> BindInfo<T> getBindInfo(String bindID) {
        return this.getAppContext().getBindInfo(bindID);
    }
    @Override
    public <T> BindInfo<T> getBindInfo(Class<T> bindType) {
        return this.getAppContext().getBindInfo(bindType);
    }
    @Override
    public <T> T getInstance(String bindID) {
        return this.getAppContext().getInstance(bindID);
    }
    @Override
    public <T> T justInject(T object) {
        return this.getAppContext().justInject(object);
    }
    @Override
    public <T> T justInject(T object, Class<?> beanType) {
        return this.getAppContext().justInject(object, beanType);
    }
    @Override
    public <T> T getInstance(Class<T> targetClass) {
        return this.getAppContext().getInstance(targetClass);
    }
    @Override
    public <T> T getInstance(BindInfo<T> info) {
        return this.getAppContext().getInstance(info);
    }
    @Override
    public <T> Provider<T> getProvider(String bindID) {
        return this.getAppContext().getProvider(bindID);
    }
    @Override
    public <T> Provider<T> getProvider(Class<T> targetClass) {
        return this.getAppContext().getProvider(targetClass);
    }
    @Override
    public <T> Provider<T> getProvider(BindInfo<T> info) {
        return this.getAppContext().getProvider(info);
    }
    @Override
    public <T> List<T> findBindingBean(Class<T> bindType) {
        return this.getAppContext().findBindingBean(bindType);
    }
    @Override
    public <T> List<Provider<T>> findBindingProvider(Class<T> bindType) {
        return this.getAppContext().findBindingProvider(bindType);
    }
    @Override
    public <T> T findBindingBean(String withName, Class<T> bindType) {
        return this.getAppContext().findBindingBean(withName, bindType);
    }
    @Override
    public <T> Provider<T> findBindingProvider(String withName, Class<T> bindType) {
        return this.getAppContext().findBindingProvider(withName, bindType);
    }
    @Override
    public <T> List<BindInfo<T>> findBindingRegister(Class<T> bindType) {
        return this.getAppContext().findBindingRegister(bindType);
    }
    @Override
    public <T> BindInfo<T> findBindingRegister(String withName, Class<T> bindType) {
        return this.getAppContext().findBindingRegister(withName, bindType);
    }
}