DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id               serial      NOT NULL,
    uuid             uuid        NOT NULL,
    order_number     bigint      NOT NULL,
    sender_uuid      uuid        NOT NULL,
    receiver_uuid    uuid        NOT NULL,
    office_uuid      uuid        NOT NULL,
    description      text        NULL,
    status           text        NOT NULL,
    cost             numeric(10, 2),
    create_timestamp timestamptz NOT NULL DEFAULT now(),
    update_timestamp timestamptz NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    UNIQUE (id)
);
CREATE UNIQUE INDEX udx_orders_id ON orders USING btree (id);
CREATE UNIQUE INDEX udx_orders_uuid ON orders USING btree (uuid);

DROP TABLE IF EXISTS office;
CREATE TABLE office
(
    id               serial      NOT NULL,
    uuid             uuid        NOT NULL,
    address          text        NOT NULL,
    work_time_begin  time        NOT NULL,
    work_time_end    time        NOT NULL,
    work_day_begin   iso_weekday NOT NULL,
    work_day_end     iso_weekday NOT NULL,
    create_timestamp timestamptz NOT NULL DEFAULT now(),
    update_timestamp timestamptz NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    UNIQUE (id)
);
CREATE UNIQUE INDEX udx_office_id ON office USING btree (id);
CREATE UNIQUE INDEX udx_office_uuid ON office USING btree (uuid);

DROP TABLE IF EXISTS contractor;
CREATE TABLE contractor
(
    id               serial      NOT NULL,
    uuid             uuid        NOT NULL,
    first_name       text        NULL,
    second_name      text        NULL,
    number_phone     text        NOT NULL,
    create_timestamp timestamptz NOT NULL DEFAULT now(),
    update_timestamp timestamptz NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    UNIQUE (id)
);
CREATE UNIQUE INDEX udx_contractor_id ON contractor USING btree (id);
CREATE UNIQUE INDEX udx_contractor_uuid ON contractor USING btree (uuid);