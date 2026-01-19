-- =========================
-- CLASSROOMS
-- =========================
INSERT INTO tb_classrooms (id, name) VALUES
                                         (1, '1º Ano A'),
                                         (2, '1º Ano B'),
                                         (3, '2º Ano A');

-- =========================
-- STUDENTS
-- =========================
INSERT INTO tb_students (id, name, age, classroom_id, registration) VALUES
                                                                        (1, 'João Silva', 15, 1, 'REG-001'),
                                                                        (2, 'Maria Oliveira', 14, 1, 'REG-002'),
                                                                        (3, 'Carlos Souza', 15, 2, 'REG-003'),
                                                                        (4, 'Ana Lima', 16, 3, 'REG-004');

-- =========================
-- GRADES
-- =========================
INSERT INTO tb_grades (id, student_id, student_name, subject, value) VALUES
-- João Silva
(1, 1, 'João Silva', 'Matemática', 7.5),
(2, 1, 'João Silva', 'Português', 6.0),
(3, 1, 'João Silva', 'História', 8.0),

-- Maria Oliveira
(4, 2, 'Maria Oliveira', 'Matemática', 9.0),
(5, 2, 'Maria Oliveira', 'Português', 8.5),
(6, 2, 'Maria Oliveira', 'História', 9.5),

-- Carlos Souza
(7, 3, 'Carlos Souza', 'Matemática', 5.0),
(8, 3, 'Carlos Souza', 'Português', 6.0),
(9, 3, 'Carlos Souza', 'História', 4.5),

-- Ana Lima
(10, 4, 'Ana Lima', 'Matemática', 7.0),
(11, 4, 'Ana Lima', 'Português', 7.5),
(12, 4, 'Ana Lima', 'História', 8.0);
