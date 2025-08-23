-- GENRES
INSERT INTO genres (id, type, description) VALUES
('11111111-1111-1111-1111-111111111111', 'Comedy', 'Funny and lighthearted'),
('22222222-2222-2222-2222-222222222222', 'Action', 'Explosions and stunts'),
('33333333-3333-3333-3333-333333333333', 'Sci-Fi', 'Science fiction themes');

-- ACTORS
INSERT INTO actors (id, name, birth_date) VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Simon Pegg', '1970-02-14'),
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Nick Frost', '1972-03-28'),
('cccccccc-cccc-cccc-cccc-cccccccccccc', 'Tom Cruise', '1962-07-03');

-- DIRECTORS
INSERT INTO directors (id, name, birth_date) VALUES
('dddddddd-dddd-dddd-dddd-dddddddddddd', 'Edgar Wright', '1974-04-18'),
('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 'Christopher McQuarrie', '1968-06-12');

-- MOVIES 
INSERT INTO movies (id, title, year, director_id, genre, movie_cast) VALUES
('f0000000-0000-0000-0000-000000000001', 'Shaun of the Dead', '2004', 'dddddddd-dddd-dddd-dddd-dddddddddddd',
    ARRAY['11111111-1111-1111-1111-111111111111']::uuid[], 
    ARRAY['aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb']::uuid[]),
('f0000000-0000-0000-0000-000000000002', 'Hot Fuzz', '2007', 'dddddddd-dddd-dddd-dddd-dddddddddddd',
    ARRAY['11111111-1111-1111-1111-111111111111','22222222-2222-2222-2222-222222222222']::uuid[],
    ARRAY['aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb']::uuid[]),
('f0000000-0000-0000-0000-000000000003', 'The World''s End', '2013', 'dddddddd-dddd-dddd-dddd-dddddddddddd',
    ARRAY['11111111-1111-1111-1111-111111111111','33333333-3333-3333-3333-333333333333']::uuid[],
    ARRAY['aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb']::uuid[]),
('f0000000-0000-0000-0000-000000000004', 'Mission: Impossible – Rogue Nation', '2015', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee',
    ARRAY['22222222-2222-2222-2222-222222222222']::uuid[],
    ARRAY['aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','cccccccc-cccc-cccc-cccc-cccccccccccc']::uuid[]),
('f0000000-0000-0000-0000-000000000005', 'Mission: Impossible – Fallout', '2018', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee',
    ARRAY['22222222-2222-2222-2222-222222222222']::uuid[],
    ARRAY['aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa','cccccccc-cccc-cccc-cccc-cccccccccccc']::uuid[]);

-- USER
INSERT INTO app_users (id, username, email, password, is_admin, favorite_movies) VALUES
('99999999-9999-9999-9999-999999999999', 'tester', 'test@example.com', 'hashedpassword', FALSE,
    ARRAY['f0000000-0000-0000-0000-000000000001','f0000000-0000-0000-0000-000000000005']::uuid[]);

