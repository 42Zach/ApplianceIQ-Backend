-- INSERT INTO appliances (name, image) VALUES
-- ('Washer', '/images/washing_machine.png'),
-- ('Dryer', '/images/clothes_dryer.png'),
-- ('Refrigerator', '/images/refrigerator.png'),
-- ('Dishwasher', '/images/dishwasher.png'),
-- ('Range', '/images/range.png'),
-- ('Microwave', '/images/microwave.png');

INSERT INTO appliances (id, name, image)
SELECT 1, 'Washer', '/images/washing_machine.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 1);

INSERT INTO appliances (id, name, image)
SELECT 2, 'Dryer', '/images/clothes_dryer.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 2);

INSERT INTO appliances (id, name, image)
SELECT 3, 'Refrigerator', '/images/refrigerator.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 3);

INSERT INTO appliances (id, name, image)
SELECT 4, 'Dishwasher', '/images/dishwasher.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 4);

INSERT INTO appliances (id, name, image)
SELECT 5, 'Range', '/images/range.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 5);

INSERT INTO appliances (id, name, image)
SELECT 6, 'Microwave', '/images/microwave.png'
WHERE NOT EXISTS (SELECT 1 FROM appliances WHERE id = 6);

-- Insert appliance types
INSERT INTO appliance_types (id, appliance_id, type)
SELECT 1, 1, 'Top Load'
WHERE NOT EXISTS (SELECT 1 FROM appliance_types WHERE id = 1);

INSERT INTO appliance_types (id, appliance_id, type)
SELECT 2, 1, 'Front Load'
WHERE NOT EXISTS (SELECT 1 FROM appliance_types WHERE id = 2);

INSERT INTO appliance_types (id, appliance_id, type)
SELECT 3, 5, 'Gas'
WHERE NOT EXISTS (SELECT 1 FROM appliance_types WHERE id = 3);

INSERT INTO appliance_types (id, appliance_id, type)
SELECT 4, 5, 'Electric'
WHERE NOT EXISTS (SELECT 1 FROM appliance_types WHERE id = 4);