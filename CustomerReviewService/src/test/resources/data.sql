INSERT INTO public.customer(
    latitude, longitude, id, name, surname, email, status)
VALUES (21.324, 12.4213, 1000, 'raif', 'erten', 'raif@gmail.com', 'ACTIVE');
INSERT INTO public.customer(
    latitude, longitude, id, name, surname, email, status)
VALUES (21.324, 12.4213, 1001, 'raif', 'erten', 'raif@gmail.com', 'ACTIVE');
INSERT INTO public.customer(
    latitude, longitude, id, name, surname, email, status)
VALUES (21.324, 12.4213, 1002, 'raif', 'erten', 'raif@gmail.com', 'ACTIVE');


INSERT INTO public.customer_review(
    customer_id, id, restaurant_id, score, comment)
VALUES (1000, 2000, 2, 'FIVE', 'sasfasfasf');
INSERT INTO public.customer_review(
    customer_id, id, restaurant_id, score, comment)
VALUES (1001, 2001, 2, 'THREE', 'sadgsadgas');
INSERT INTO public.customer_review(
    customer_id, id, restaurant_id, score, comment)
VALUES (1002, 2002, 3, 'ONE', 'asfasfasf');