CREATE TRIGGER pro_insert_trigger
AFTER INSERT ON pro
FOR EACH ROW
BEGIN
    INSERT INTO product_history (
        product_id,
        title,
        price,
        description,
        category,
        image,
        created_by,
        created_date,
        action_type,
        action_timestamp,
        modified_by
    ) VALUES (
        NEW.id,
        NEW.title,
        NEW.price,
        NEW.description,
        NEW.category,
        NEW.image,
        NEW.created_by,
        NEW.created_date,
        'INSERT',
        CURRENT_TIMESTAMP(6),
        NEW.modified_by
    );
END;
