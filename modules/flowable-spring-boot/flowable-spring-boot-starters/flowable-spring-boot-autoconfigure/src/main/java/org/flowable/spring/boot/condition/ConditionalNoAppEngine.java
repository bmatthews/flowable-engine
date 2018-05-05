/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.flowable.spring.boot.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;

/**
 * A meta {@link org.springframework.context.annotation.Conditional} annotation that checks if the Process engine
 * should / can be activated.
 * <p>
 * By default the process engine is activated when the {@link org.flowable.engine.ProcessEngine} and
 * {@link org.flowable.spring.SpringProcessEngineConfiguration} are present.
 * Additionally the property {@code flowable.process.enabled} is checked, if it is {@code true} or missing
 * the process engine would be enabled.
 *
 * @author Filip Hrisafov
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@ConditionalOnMissingClass(value = {
    "org.flowable.app.engine.AppEngine",
    "org.flowable.app.spring.SpringAppEngineConfiguration"
})
public @interface ConditionalNoAppEngine {

}
