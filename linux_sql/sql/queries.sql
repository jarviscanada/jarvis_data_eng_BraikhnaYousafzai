DROP FUNCTION IF EXISTS round5(ts timestamp);
CREATE FUNCTION round5 (ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
     LANGUAGE PLPGSQL;

DROP FUNCTION IF EXISTS percent_mem_used(total_mem integer, free_mem integer);
CREATE FUNCTION IF NOT EXISTS percent_mem_usage (total_mem INT, free_mem INT) RETURNS INT AS
    $$
    BEGIN
        RETURN CAST(((CAST((total_mem - free_mem) AS FLOAT)/CAST(total_mem AS FLOAT))*100) AS INT);
    END;
    $$
        LANGUAGE PLPGSQl;

SELECT cpu_number, id, total_mem FROM host_info ORDER BY total_mem DESC;

SELECT host_usage.host_id AS host_id, hi.hostname AS host_name,
       round5 (host_usage.timestamp) AS five_min_interval,
       AVG(percent_mem_usage(hi.total_mem, host_usage.memory_free)) AS avg_mem_used_percentage
    FROM host_usage
    INNER JOIN host_info hi on hi.id = host_usage.host_id
    GROUP BY host_id, host_name, five_min_interval
    ORDER BY host_id ASC, five_min_interval ASC;

SELECT host_id, round5(host_usage.timestamp) AS five_min_interval,
        COUNT(round5(host_usage.timestamp)) AS num_data_points
    FROM host_usage
    GROUP BY host_id, five_min_interval
    HAVING COUNT(round5(host_usage.timestamp)) < 3
    ORDER BY host_id ASC, five_min_interval ASC;