# RPG Combat Kata

Este proyecto implementa un sistema de combate para un juego de rol (RPG) siguiendo la metodología TDD (Test-Driven Development). Los personajes pueden infligir daño a otros, considerando su nivel, facción y rango de ataque.

## 🎮 Características del Sistema

- **Sistema de Combate**: Los personajes pueden atacar a otros con diferentes tipos (melee/ranged)
- **Modificadores de Daño**: El daño se modifica según la diferencia de nivel entre atacante y objetivo
- **Sistema de Facciones**: Los personajes pueden unirse a facciones y no pueden atacar a sus aliados
- **Rangos de Ataque**: Los personajes melee tienen rango 2, los ranged tienen rango 20
- **Pruebas Unitarias Completas**: Cobertura completa con JUnit 5

## ⚔️ Mecánicas de Combate

### Tipos de Personajes
- **Melee**: Rango de ataque 2 unidades
- **Ranged**: Rango de ataque 20 unidades

### Modificadores de Daño por Nivel
- **Atacante 5+ niveles superior**: +50% de daño
- **Atacante 5+ niveles inferior**: -50% de daño
- **Diferencia menor a 5 niveles**: Daño normal

### Restricciones de Combate
- No se puede atacar a sí mismo
- No se puede atacar a aliados de la misma facción
- No se puede atacar si el personaje está muerto
- El daño debe ser mayor a 0
- El objetivo debe estar dentro del rango de ataque

## 🚀 Cómo Ejecutar

### Prerrequisitos
- Java 8 o superior
- Maven 3.6.3 o superior

### Instalación
```bash
# Clonar el repositorio
git clone <url-del-repositorio>
cd Rpg-combat-kata

# Compilar el proyecto
mvn compile

# Ejecutar las pruebas
mvn test

# Generar reporte de cobertura
mvn jacoco:report
```

## 🧪 Pruebas

El proyecto incluye pruebas unitarias que cubren:
- ✅ Creación de personajes
- ✅ Sistema de daño básico
- ✅ Prevención de auto-daño
- ✅ Modificadores de daño por nivel
- ✅ Restricciones de facción
- ✅ Validaciones de rango de ataque

### Ejecutar Pruebas
```bash
mvn test
```

## 📊 Calidad del Código

- **Cobertura de Código**: JaCoCo configurado
- **Complejidad Ciclomática**: Límites configurados (clase: 25, método: 8)
- **Estándares de Código**: Maven Enforcer Plugin
- **Documentación**: Javadoc configurado

## 🏗️ Arquitectura

### Clase Principal: `Character`
- **Atributos**: salud, nivel, tipo, facción, rango de ataque
- **Métodos principales**:
  - `dealDamage()`: Inflige daño a otro personaje
  - `joinFaction()`: Une el personaje a una facción
  - `getHealth()`: Obtiene la salud actual

### Refactoring Implementado
- ✅ Separación de responsabilidades
- ✅ Métodos privados para validaciones
- ✅ Encapsulación mejorada
- ✅ Eliminación de logging en lógica de negocio

## 🤝 Contribución

Para contribuir al proyecto:

1. Fork del repositorio
2. Crear una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`)
3. Implementar cambios con pruebas unitarias
4. Ejecutar `mvn test` para verificar que todo funciona
5. Commit con mensaje descriptivo
6. Push a tu fork
7. Crear Pull Request

## 📝 Licencia

Este proyecto está bajo la licencia MIT.

## 🎯 Próximas Funcionalidades

- [ ] Sistema de curación
- [ ] Objetos y equipamiento
- [ ] Efectos de estado (veneno, parálisis, etc.)
- [ ] Sistema de experiencia y subida de nivel
- [ ] Combate por turnos
