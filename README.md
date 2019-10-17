# 1. Create project using maven command
```
mvn archetype:generate -DgroupId=th.ac.kmitl.it.oot.hibernate -DartifactId=MyHibernate -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
### Note!!
```DgroupId``` is your package name. Package names are written in all lower case to avoid conflict with the names of classes or interfaces.

Companies use their reversed Internet domain name to begin their package names—for example, com.example.mypackage for a package named mypackage created by a programmer at example.com.

Name collisions that occur within a single company need to be handled by convention within that company, perhaps by including the region or the project name after the company name (for example, com.example.region.mypackage).

Packages in the Java language itself begin with java. or javax.

In some cases, the internet domain name may not be a valid package name. This can occur if the domain name contains a hyphen or other special character, if the package name begins with a digit or other character that is illegal to use as the beginning of a Java name, or if the package name contains a reserved Java keyword, such as "int". In this event, the suggested convention is to add an underscore. For example:

| Domain Name         | Package Name Prefix  |
|---------------------|----------------------|
| oot.it.kmitl.ac.th  | th.ac.kmitl.it.oot   |
| example.int         | int_.example         |
| 123name.example.com | com.example._123name |

```DartifactId``` is your application name. It will releate to your end production application.

```DarchetypeArtifactId``` is type of application. We use ```maven-archetype-quickstart``` to create basic application, and code structure. You can study more about this at [https://maven.apache.org/guides/introduction/introduction-to-archetypes.html]()

# 2. Add plugin for run application
You can compile/build your application using command as follow.

```
mvn package
```

To run application, you can use java command, For example.,

```
java -cp target/MyHibernate-1.0-SNAPSHOT.jar th.ac.kmitl.it.oot.hibernate.App
```
Where ```MyHibernate``` is your application name, and ```-1.0-SNAPSHOT``` is your application version (reference and config in pom.xml). And ```th.ac.kmitl.it.oot.hibernate.App``` is package that contain main function.

To make it easier you can use plugin, by add plugin to your ```pom.xml```.

``` xml
<build>
   <plugins>
      <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.8.1</version>
         <configuration>
            <source>1.8</source>
            <target>1.8</target>
         </configuration>
      </plugin>
      <plugin>
         <groupId>org.codehaus.mojo</groupId>
         <artifactId>exec-maven-plugin</artifactId>
         <version>1.6.0</version>
         <configuration>
            <mainClass>th.ac.kmitl.it.oot.hibernate.App</mainClass>
         </configuration>
      </plugin>
   </plugins>
</build>
```

After install plugin, Now you can run your application using 

```
mvn exec:java
```
!Note, If you update your application. You still need to run ```mvn package``` before run application.


# 3. Add hibernate to your application
Edit ```pom.xml```. By add this follow xml into your dependencies section.

```xml
<dependency>
	<groupId>org.hibernate</groupId>
	<artifactId>hibernate-core</artifactId>
	<version>4.1.12.Final</version>
</dependency>
```

!!Note.
 
* You can find external dependencies at [https://mvnrepository.com/]()
* Version number can change.

# 4. SQLite connect libarary to your application

```xml
<dependency>
	<groupId>org.xerial</groupId>
	<artifactId>sqlite-jdbc</artifactId>
	<version>3.28.0</version>
</dependency>
```

# 5. Make config to connect between hibernate and sqlite

* Create ```SQLiteDialect.java``` under folder ```src/main/java/org/hibernate/dialect```. This is java for SQLite

```java
/*
 * The author disclaims copyright to this source code.  In place of
 * a legal notice, here is a blessing:
 *
 *    May you do good and not evil.
 *    May you find forgiveness for yourself and forgive others.
 *    May you share freely, never taking more than you give.
 *
 */
package org.hibernate.dialect;

import java.sql.Types;

import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class SQLiteDialect extends Dialect {
  public SQLiteDialect() {
    registerColumnType(Types.BIT, "boolean");
    registerColumnType(Types.TINYINT, "tinyint");
    registerColumnType(Types.SMALLINT, "smallint");
    registerColumnType(Types.INTEGER, "integer");
    registerColumnType(Types.BIGINT, "bigint");
    registerColumnType(Types.FLOAT, "float");
    registerColumnType(Types.REAL, "real");
    registerColumnType(Types.DOUBLE, "double");
    registerColumnType(Types.NUMERIC, "numeric($p, $s)");
    registerColumnType(Types.DECIMAL, "decimal");
    registerColumnType(Types.CHAR, "char");
    registerColumnType(Types.VARCHAR, "varchar($l)");
    registerColumnType(Types.LONGVARCHAR, "longvarchar");
    registerColumnType(Types.DATE, "date");
    registerColumnType(Types.TIME, "time");
    registerColumnType(Types.TIMESTAMP, "datetime");
    registerColumnType(Types.BINARY, "blob");
    registerColumnType(Types.VARBINARY, "blob");
    registerColumnType(Types.LONGVARBINARY, "blob");
    registerColumnType(Types.BLOB, "blob");
    registerColumnType(Types.CLOB, "clob");
    registerColumnType(Types.BOOLEAN, "boolean");

    //registerFunction( "abs", new StandardSQLFunction("abs") );
    registerFunction( "concat", new VarArgsSQLFunction(StandardBasicTypes.STRING, "", "||", "") );
    //registerFunction( "length", new StandardSQLFunction("length", StandardBasicTypes.LONG) );
    //registerFunction( "lower", new StandardSQLFunction("lower") );
    registerFunction( "mod", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "?1 % ?2" ) );
    registerFunction( "quote", new StandardSQLFunction("quote", StandardBasicTypes.STRING) );
    registerFunction( "random", new NoArgSQLFunction("random", StandardBasicTypes.INTEGER) );
    registerFunction( "round", new StandardSQLFunction("round") );
    registerFunction( "substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING) );
    registerFunction( "substring", new SQLFunctionTemplate( StandardBasicTypes.STRING, "substr(?1, ?2, ?3)" ) );
    registerFunction( "trim", new AbstractAnsiTrimEmulationFunction() {
        protected SQLFunction resolveBothSpaceTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1)");
        }

        protected SQLFunction resolveBothSpaceTrimFromFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?2)");
        }

        protected SQLFunction resolveLeadingSpaceTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1)");
        }

        protected SQLFunction resolveTrailingSpaceTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1)");
        }

        protected SQLFunction resolveBothTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "trim(?1, ?2)");
        }

        protected SQLFunction resolveLeadingTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "ltrim(?1, ?2)");
        }

        protected SQLFunction resolveTrailingTrimFunction() {
          return new SQLFunctionTemplate(StandardBasicTypes.STRING, "rtrim(?1, ?2)");
        }
    } );
    //registerFunction( "upper", new StandardSQLFunction("upper") );
  }

  public boolean supportsIdentityColumns() {
    return true;
  }

  /*
  public boolean supportsInsertSelectIdentity() {
    return true; // As specify in NHibernate dialect
  }
  */

  public boolean hasDataTypeInIdentityColumn() {
    return false; // As specify in NHibernate dialect
  }

  /*
  public String appendIdentitySelectToInsert(String insertString) {
    return new StringBuffer(insertString.length()+30). // As specify in NHibernate dialect
      append(insertString).
      append("; ").append(getIdentitySelectString()).
      toString();
  }
  */

  public String getIdentityColumnString() {
    // return "integer primary key autoincrement";
    return "integer";
  }

  public String getIdentitySelectString() {
    return "select last_insert_rowid()";
  }

  public boolean supportsLimit() {
    return true;
  }

  public boolean bindLimitParametersInReverseOrder() {
    return true;
  }

  protected String getLimitString(String query, boolean hasOffset) {
    return new StringBuffer(query.length()+20).
      append(query).
      append(hasOffset ? " limit ? offset ?" : " limit ?").
      toString();
  }

  public boolean supportsTemporaryTables() {
    return true;
  }

  public String getCreateTemporaryTableString() {
    return "create temporary table if not exists";
  }

  public boolean dropTemporaryTableAfterUse() {
    return true; // TODO Validate
  }

  public boolean supportsCurrentTimestampSelection() {
    return true;
  }

  public boolean isCurrentTimestampSelectStringCallable() {
    return false;
  }

  public String getCurrentTimestampSelectString() {
    return "select current_timestamp";
  }

  public boolean supportsUnionAll() {
    return true;
  }

  public boolean hasAlterTable() {
    return false; // As specify in NHibernate dialect
  }

  public boolean dropConstraints() {
    return false;
  }

  /*
  public String getAddColumnString() {
    return "add column";
  }
  */

  public String getForUpdateString() {
    return "";
  }

  public boolean supportsOuterJoinForUpdate() {
    return false;
  }

  public String getDropForeignKeyString() {
    throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
  }

  public String getAddForeignKeyConstraintString(String constraintName,
      String[] foreignKey, String referencedTable, String[] primaryKey,
      boolean referencesPrimaryKey) {
    throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
  }

  public String getAddPrimaryKeyConstraintString(String constraintName) {
    throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
  }

  public boolean supportsIfExistsBeforeTableName() {
    return true;
  }

  public boolean supportsCascadeDelete() {
    return true;
  }

  /* not case insensitive for unicode characters by default (ICU extension needed)
  public boolean supportsCaseInsensitiveLike() {
    return true;
  }
  */

  public boolean supportsTupleDistinctCounts() {
    return false;
  }

  public String getSelectGUIDString() {
    return "select hex(randomblob(16))";
  }
}
```

* Create your first model(object response for database table) in same folder of main function (```/src/main/th/ac/kmitl/it/oot/hibernate```). Filename shoude be the same as database table. (E.g., Contact.java will response for contact table in database)

```java
package th.ac.kmitl.it.oot.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name = "contact")
public class Contact {
	private Integer id;
	private String name;
	private String email;

	public Contact() {

	}

	public Contact(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

```
* In main ```src/main``` create folder name ```resources```. Then create ```hibernate.cfg.xml```. Your path of this file should be ```src/main/hibernate.cfg.xml```
* Edit hibernate.cfg.xml as follow

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
	<session-factory>
		<property name="show_sql">true</property>
		<property name="format_sql">true</property>
		<property name="dialect">org.hibernate.dialect.SQLiteDialect</property>
		<property name="connection.driver_class">org.sqlite.JDBC</property>
		<property name="connection.url">jdbc:sqlite:mydb.db</property>
		<property name="connection.username"></property>
		<property name="connection.password"></property>
		<property name="hibernate.hbm2ddl.auto">update</property>
		<mapping class="th.ac.kmitl.it.oot.hibernate.Contact"/>
	</session-factory>
</hibernate-configuration>
```
* Form ```hibernate.cfg.xml```. ```mydb.db``` is your sqlite database file. And ```<mapping class="th.ac.kmitl.it.oot.hibernate.Contact"/>``` is tell that ```Contact.java``` is object that response to database table.

# 6. Write application to test hibernate and SQLite

