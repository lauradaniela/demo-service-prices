CREATE TABLE product (
 id BIGINT NOT NULL PRIMARY KEY,
 name char(30)
);

CREATE TABLE price (
  id BIGINT NOT NULL PRIMARY KEY,
  start_date TIMESTAMP NOT NULL,
  end_date TIMESTAMP NOT NULL,
  priority integer NOT NULL,
  product_value NUMERIC(20, 2) NOT NULL,
  currency char(3) NOT NULL,
  brand_id BIGINT NOT NULL REFERENCES brand(id),
  product_id BIGINT NOT NULL REFERENCES product(id)
 );