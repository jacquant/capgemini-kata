CREATE SEQUENCE account_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE transaction_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE account
(
    id          BIGINT  NOT NULL,
    amount      DECIMAL NOT NULL,
    customer_id BIGINT  NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id         BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE transaction
(
    id               BIGINT    NOT NULL,
    transaction_type VARCHAR(31),
    target_id        BIGINT,
    source_id        BIGINT,
    amount           DECIMAL   NOT NULL,
    created_date     TIMESTAMP NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_SOURCE FOREIGN KEY (source_id) REFERENCES account (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_TARGET FOREIGN KEY (target_id) REFERENCES account (id);