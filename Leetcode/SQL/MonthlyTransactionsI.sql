SELECT
    TO_CHAR(trans_date, 'YYYY-MM') AS MONTH,
    COUNTRY,
    COUNT(id) AS trans_count,
    COALESCE(SUM(CASE WHEN state = 'approved' THEN 1 END), 0) AS approved_count,
    SUM(amount) AS trans_total_amount,
    COALESCE(SUM(CASE WHEN STATE = 'approved' THEN AMOUNT END), 0) AS  approved_total_amount
FROM TRANSACTIONS
GROUP BY TO_CHAR(trans_date, 'YYYY-MM'), COUNTRY;