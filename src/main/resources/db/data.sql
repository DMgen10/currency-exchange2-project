INSERT INTO currencies(code, full_name,sign)
VALUES ('USD', 'United States dollar', '$'),
       ('EUR', 'Euro', '€'),
       ('RUB', 'Russian Ruble', '₽');

INSERT INTO exchange_rates(base_currency_id, target_currency_id, rate)
VALUES ((SELECT id FROM currencies WHERE code = 'USD'),(SELECT id FROM currencies WHERE code = 'EUR'),0.91),
       ((SELECT id FROM currencies WHERE code = 'USD'),(SELECT id FROM currencies WHERE code = 'RUB'),82.17);
