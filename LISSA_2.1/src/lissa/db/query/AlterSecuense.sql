-------------------------------------------------------------------------------- 
select max(a.idatencion) from atencion a;
ALTER SEQUENCE atencion_idatencion_seq RESTART WITH 40359;
--------------------------------------------------------------------------------
select max(a.idareacaja) from area_caja a;
alter sequence area_caja_idareacaja_seq restart with 3;
--------------------------------------------------------------------------------
select max(a.idatencionhc) from atencionhc a;
alter sequence  atencionhc_idatencionhc_seq restart with 1;
-------------------------------------------------------------------
select max(a.idbeneficio) from beneficio a;
alter sequence  beneficio_idbeneficio_seq restart with 9;
--------------------------------------------------------------------------------
select max(a.idcaja) from caja a;
alter sequence caja_idcaja_seq  restart with 2431;
--------------------------------------------------------------------------------
select max(a.id_cie10) from cie10 a;
alter sequence  cie10_id_cie10_seq restart with 14201;
--------------------------------------------------------------------------------
select max(a.idcita) from cita a;
alter sequence cita_idcita_seq  restart with 2;
--------------------------------------------------------------------------------
select max(a.idcomprobante) from comprobante a;
alter sequence comprobante_idcomprobante_seq restart with 24632;
--------------------------------------------------------------------------------
select max(a.idcomprobantedetalle) from comprobante_detalle a;
alter sequence items_boleta_id_item_boleta_seq  restart with 238428;
--------------------------------------------------------------------------------
select max(a.idcomprobanteserie) from comprobante_serie a;
alter sequence comprobante_serie_idcomprobanteserie_seq  restart with 1;
--------------------------------------------------------------------------------
select max(a.idegreso) from egreso a;
alter sequence egreso_idegreso_seq  restart with 3;
--------------------------------------------------------------------------------
select max(a.idegresodetalle) from egreso_detalle a;
alter sequence egreso_detalle_idegresodetalle_seq restart with 4;
--------------------------------------------------------------------------------
select max(a.id_especialidad) from especialidad a;
alter sequence especialidad_id_especialidad_seq  restart with 35;
--------------------------------------------------------------------------------
select max(a.idestadocivil) from estado_civil a;
alter sequence estado_civil_idestadocivil_seq  restart with 5;
--------------------------------------------------------------------------------
select max(a.idfondosolidaridad) from fondo_solidaridad a;
alter sequence fondo_solidaridad_idfondosolidaridad_seq  restart with 4798;
--------------------------------------------------------------------------------
select max(a.idformapago) from forma_pago a;
alter sequence forma_pago_idformapago_seq  restart with 1;
--------------------------------------------------------------------------------
select max(a.idfuncionvital) from funcion_vital a;
alter sequence funcion_vital_idfuncionvital_seq restart with 1;
--------------------------------------------------------------------------------
select max(a.idhistoriaclinica) from historia_clinica a;
alter sequence historia_clinica_idhistoriaclinica_seq  restart with 26559;
--------------------------------------------------------------------------------
select max(a.idhistorialatencionfps) from historial_atencion_fps a;
alter sequence historial_atencion_fps_idhistorialatencionfps_seq  restart with 4134;
--------------------------------------------------------------------------------
select max(a.id_medico) from medico a;
alter sequence medico_id_medico_seq  restart with 137;
--------------------------------------------------------------------------------
select max(a.idmedicoderivaatiende) from medico_deriva_atiende a;
alter sequence medico_deriva_atiende_idmedicoderivaatiende_seq01 restart with 13022;
--------------------------------------------------------------------------------
select max(a.idmedicoespecialidad) from medico_especialidad a;
alter sequence medico_especialidad_idmedicoespecialidad_seq restart with 86;
--------------------------------------------------------------------------------
select max(a.idpago) from pago a;
alter sequence pago_idpago_seq restart with 86;
--------------------------------------------------------------------------------
select max(a.idpaquetefondo) from paquete_fondo_detalle a;
alter sequence paquete_fondo_detalle_idpaquetefondo_seq restart with 86;
--------------------------------------------------------------------------------
select max(a.idpaquetefs) from paquete_fondo_solidaridad a;
alter sequence paquete_fondo_solidaridad_idpaquetefs_seq restart with 2;
--------------------------------------------------------------------------------
select max(a.idpermiso) from permiso a;
alter sequence permiso_idpermiso_seq restart with 2;
--------------------------------------------------------------------------------
select max(a.idpersona) from persona a;
alter sequence persona_idpersona_seq restart with 2;
--------------------------------------------------------------------------------
select max(a.idpersonaempresa) from persona_empresa a;
alter sequence persona_empresa_idpersonaempresa_seq restart with 12;
--------------------------------------------------------------------------------
select max(a.id_persona_juridica) from persona_juridica a;
alter sequence persona_juridica_id_persona_juridica_seq restart with 136;
--------------------------------------------------------------------------------
select max(a.idprocedimiento) from procedimiento a;
alter sequence procedimiento_idprocedimiento_seq restart with 721;
--------------------------------------------------------------------------------
select max(a.idprocedimientotarifario) from procedimiento_tarifario a;
alter sequence procedimiento_tarifario_idprocedimientotarifario_seq restart with 2161;
--------------------------------------------------------------------------------
select max(a.idrol) from rol a;
alter sequence roles_id_rol_seq restart with 12;
--------------------------------------------------------------------------------
select max(a.id_seguro_vida) from seguro_vida a;
alter sequence seguro_vida_id_seguro_vida_seq restart with 10;
--------------------------------------------------------------------------------
select max(a.id_seguro_vida_usa_persona) from seguro_vida_usa_persona a;
alter sequence seguro_vida_usa_persona_id_seguro_vida_usa_persona_seq restart with 2960;
--------------------------------------------------------------------------------
select max(a.idservicio) from servicio a;
alter sequence servicio_idservicio_seq restart with 29;
--------------------------------------------------------------------------------
select max(a.id_servicio_fs) from servicio_fondo_solidaridad a;
alter sequence servicio_fondo_solidaridad_id_servicio_fs_seq restart with 2121;
--------------------------------------------------------------------------------
select max(a.idserviciosfs) from servicios_fondo_solidaridad a;
alter sequence servicios_fondo_solidaridad_idserviciosfs_seq restart with 1508;
--------------------------------------------------------------------------------
select max(a.idtarifario) from tarifario a;
alter sequence tarifario_idtarifario_seq restart with 6;
--------------------------------------------------------------------------------
select max(a.idtipocomprobante) from tipo_comprobante a;
alter sequence tipo_comprobante_idtipocomprobante_seq restart with 7;
--------------------------------------------------------------------------------
select max(a.idtipodocidentidad) from tipo_docidentidad a;
alter sequence tipo_docidentidad_idtipodocidentidad_seq restart with 5;
--------------------------------------------------------------------------------
select max(a.idtipohc) from tipo_historia_clinica a;
alter sequence tipo_historia_clinica_idtipohc_seq restart with 4;
--------------------------------------------------------------------------------
select max(a.id_tipo_medico) from tipo_medico a;
alter sequence tipo_medico_id_tipo_medico_seq restart with 4;
--------------------------------------------------------------------------------
select max(a.id_usuario) from usuario a;
alter sequence usuario_id_usuario_seq restart with 42;
--------------------------------------------------------------------------------
select max(a.idusuariopermiso) from usuario_permiso a;
alter sequence usuario_permiso_idusuariopermiso_seq restart with 1;
--------------------------------------------------------------------------------
select max(a.id_usuario_rol) from usuario_rol a;
alter sequence usurio_rol_id_usuario_rol_seq restart with 104;
