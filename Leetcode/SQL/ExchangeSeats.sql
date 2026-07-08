UPDATE SEAT
SET student = CASE 
    WHEN t.id % 2 = 1 AND t.id < (SELECT MAX(id) FROM SEAT) 
        THEN (SELECT student FROM SEAT WHERE id = t.id + 1)
    WHEN t.id % 2 = 0 
        THEN (SELECT student FROM SEAT WHERE id = t.id - 1)
    ELSE SEAT.student
END
FROM SEAT t
WHERE SEAT.id = t.id
RETURNING SEAT.id, SEAT.student;
