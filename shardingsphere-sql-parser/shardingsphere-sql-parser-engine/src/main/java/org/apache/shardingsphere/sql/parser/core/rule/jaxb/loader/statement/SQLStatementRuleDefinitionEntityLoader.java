/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.core.rule.jaxb.loader.statement;

import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import org.apache.shardingsphere.sql.parser.core.rule.jaxb.entity.statement.SQLStatementRuleDefinitionEntity;
import org.apache.shardingsphere.sql.parser.core.rule.jaxb.loader.RuleDefinitionEntityLoader;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;

/**
 * SQL statement rule definition entity loader for JAXB.
 *
 * @author zhangliang
 */
public final class SQLStatementRuleDefinitionEntityLoader implements RuleDefinitionEntityLoader {
    
    @Override
    @SneakyThrows
    public SQLStatementRuleDefinitionEntity load(final String sqlStatementRuleDefinitionFile) {
        InputStream inputStream = SQLStatementRuleDefinitionEntityLoader.class.getClassLoader().getResourceAsStream(sqlStatementRuleDefinitionFile);
        Preconditions.checkNotNull(inputStream, "Cannot load SQL statement rule definition file: %s, ", sqlStatementRuleDefinitionFile);
        return (SQLStatementRuleDefinitionEntity) JAXBContext.newInstance(SQLStatementRuleDefinitionEntity.class).createUnmarshaller().unmarshal(inputStream);
    }
}
