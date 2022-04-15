CREATE TABLE orders(
    id serial NOT NULL,
    uuid uuid NOT NULL,
    order_number bigint NOT NULL,
    sender_uuid uuid NOT NULL,
    receiver_uuid uuid NOT NULL,
    office_uuid uuid NOT NULL,
    description text NULL,
    status text NOT NULL,
    cost numeric(10,2),
    create_timestamp timestamptz NOT NULL DEFAULT now(),
    update_timestamp timestamptz NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    UNIQUE (id)
);
CREATE UNIQUE INDEX udx_orders_id ON orders USING btree (id);
CREATE UNIQUE INDEX udx_orders_uuid ON orders USING btree (uuid);