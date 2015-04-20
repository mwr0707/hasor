/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
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
package net.hasor.rsf.rpc.client;
import io.netty.channel.Channel;
import java.net.URL;
import net.hasor.rsf.address.InterAddress;
/**
 * 为{@link InnerRsfCustomerHandler}提供{@link RsfClientRequestManager}列表维护。
 * 同时负责创建和销毁{@link RsfClientRequestManager}的功能。
 * @version : 2014年9月12日
 * @author 赵永春(zyc@hasor.net)
 */
class InnerRsfClient extends AbstractRsfClient {
    private RsfClientRequestManager requestManager;
    private InterAddress            hostAddress;
    //
    public InnerRsfClient(RsfClientRequestManager requestManager, InterAddress hostAddress) {
        this.requestManager = requestManager;
        this.hostAddress = hostAddress;
    }
    public boolean isActive() {
        return networkConnection.isActive();
    }
    public void close() {
        networkConnection.close();
    }
    public Channel getChannel() {
        return networkConnection.getChannel();
    }
    public RsfClientRequestManager getRequestManager() {
        return this.requestManager;
    }
    public URL getHostAddress() {
        return networkConnection.getHostAddress();
    }
}