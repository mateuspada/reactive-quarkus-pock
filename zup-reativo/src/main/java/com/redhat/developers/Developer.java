package com.redhat.developers;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.sqlclient.Pool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;

import java.util.List;

public class Developer {

    private Long id;

    private String name;

    private Developer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Developer of(Row row){
        return new Developer(row.getLong("id"), row.getString("name"));
    }

    public static Multi<Developer> listAll(Pool client){
        return client.query("select id, name, sleep(1) from Developer")
            .toMulti()
            .flatMap(rs -> Multi.createFrom().iterable(rs))
            .map(Developer::of);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
