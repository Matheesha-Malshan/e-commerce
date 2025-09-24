CREATE TRIGGER pro_delete_trigger
AFTER DELETE ON pro
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
        OLD.id,
        OLD.title,
        OLD.price,
        OLD.description,
        OLD.category,
        OLD.image,
        OLD.created_by,
        OLD.created_date,
        'DELETE',
        CURRENT_TIMESTAMP(6),
        OLD.modified_by
    );
END;
