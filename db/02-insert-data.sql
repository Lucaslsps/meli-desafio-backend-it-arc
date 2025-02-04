INSERT INTO notifications (status, city_name, notification_date)
VALUES
    ('PENDING', 'São Paulo', NOW() + INTERVAL '1 day'),
    ('PENDING', 'Rio de Janeiro', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Belo Horizonte', NOW() - INTERVAL '1 day'),
    ('PENDING', 'Porto Alegre', NOW() + INTERVAL '1 days'),
    ('PENDING', 'Salvador', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Curitiba', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Fortaleza', NOW() + INTERVAL '1 days'),
    ('PENDING', 'Recife', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Manaus', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Brasília', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'São Luís', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Natal', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Vitória', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Maceió', NOW() - INTERVAL '1 days'),
    ('ERROR', 'João Pessoa', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Goiânia', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Belém', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Florianópolis', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Campo Grande', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'São José dos Campos', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Teresina', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Aracaju', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Cuiabá', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Porto Velho', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Macapá', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Boa Vista', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Rio Branco', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Palmas', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'São Bernardo do Campo', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Santos', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Londrina', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Maringá', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Sorocaba', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Niterói', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Joinville', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Anápolis', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Uberlândia', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Caxias do Sul', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Ribeirão Preto', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Bauru', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'São Carlos', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Jundiaí', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Pelotas', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Campina Grande', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Blumenau', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Vila Velha', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Franca', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Caruaru', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Mossoró', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Cascavel', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Foz do Iguaçu', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Taboão da Serra', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Barueri', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Itajaí', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Volta Redonda', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'São José do Rio Preto', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Ipatinga', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Aparecida de Goiânia', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Olinda', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Marabá', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Timon', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Juiz de Fora', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Ponta Grossa', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Dourados', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Rondonópolis', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Passo Fundo', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Santana de Parnaíba', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Guarulhos', NOW() - INTERVAL '1 days'),
    ('ERROR', 'São Vicente', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Uberaba', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Juazeiro do Norte', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Paulista', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Imperatriz', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Itabuna', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Araguaína', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Boa Esperança', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Garanhuns', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Sinop', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Ji-Paraná', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Caratinga', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Luziânia', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Alvorada', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Vitória da Conquista', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Patos', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Ilhéus', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Lages', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Arapiraca', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Resende', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Criciúma', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Sete Lagoas', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Parnaíba', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Ipameri', NOW() - INTERVAL '1 days'),
    ('ERROR', 'Nova Iguaçu', NOW() - INTERVAL '1 days'),
    ('PENDING', 'Santa Maria', NOW() + INTERVAL '1 days'),
    ('PROCESSED', 'Cabo Frio', NOW() - INTERVAL '1 days');

INSERT INTO users (name, city_name)
VALUES
    ('Lucas', 'São Paulo'),
    ('Maria', 'Rio de Janeiro'),
    ('João', 'Belo Horizonte'),
    ('Ana', 'Porto Alegre'),
    ('Carlos', 'Salvador'),
    ('Paula', 'Curitiba'),
    ('Pedro', 'Fortaleza'),
    ('Mariana', 'Recife'),
    ('Rafael', 'Manaus'),
    ('Fernanda', 'Brasília'),
    ('Gabriel', 'São Luís'),
    ('Juliana', 'Natal'),
    ('Bruno', 'Vitória'),
    ('Camila', 'Maceió'),
    ('Felipe', 'João Pessoa'),
    ('Larissa', 'Goiânia'),
    ('Gustavo', 'Belém'),
    ('Isabela', 'Florianópolis'),
    ('Rodrigo', 'Campo Grande'),
    ('Aline', 'São José dos Campos');