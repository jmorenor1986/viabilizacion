--
ALTER TABLE cache_usr
ADD CONSTRAINT fk_cache_usr_log
FOREIGN KEY (log_id) REFERENCES log
;
--
ALTER TABLE log
ADD CONSTRAINT fk_log_principal_request
FOREIGN KEY (principal_request_id) REFERENCES principal_request
;
--
ALTER TABLE log
ADD CONSTRAINT fk_log_servicio
FOREIGN KEY (servicio_id) REFERENCES servicio
;