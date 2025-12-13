Readme for My-LibGDX

A repositório para baixar e empacotar todas as bibliotecas oficiais do libGDX, gerando artefatos organizados e relatórios de status (geral e por dependência). Ideal para cache, auditoria de versões e diagnóstico rápido de falhas de download.

---

Projeto

- Nome: My-LibGDX
- Objetivo: Forçar o download de todos os módulos libGDX (núcleo, backends, nativos, extras e internos), gerar um pacote único e pacotes individuais, e produzir relatórios de sucesso/falha.
- Stack: Gradle, Java 17, GitHub Actions

---

Estrutura

`
My-LibGDX/
 ├─ .github/workflows/gradle.yml   # Workflow CI
 ├─ gradle/                        # Wrapper (scripts)
 ├─ wrapper/                       # Wrapper (jar + properties)
 ├─ build.gradle                   # Dependências + tasks
 ├─ gradle.properties              # Configurações gerais
 ├─ gradlew / gradlew.bat          # Executáveis do wrapper
 └─ settings.gradle                 # Nome do projeto
`

---

O que é baixado

- Núcleo: gdx
- Backends: desktop (LWJGL3), Android, iOS (RoboVM/MobiVM), HTML5 (GWT)
- Nativos: desktop, ARM (v7a/arm64), x86/x86_64, iOS, GWT
- Extras: Box2D, FreeType, Tools, AI, Controllers, Bullet, Video
- Internos: JNigen, Setup, Tests

Observação: alguns módulos são internos/experimentais; estão incluídos para cobertura completa.

---

Como usar localmente

1. Instale Java 17 (Temurin recomendado).
2. Execute:
   `bash
   ./gradlew build --refresh-dependencies
   ./gradlew copyAllDependencies
   ./gradlew generateReport
   `
3. Resultados:
   - build/all-libs/ → todas as libs juntas
   - build/libs-individual/<lib>/ → lib isolada + report-<lib>.txt
   - build/libs-report.txt → relatório geral

---

Como usar no GitHub Actions

- O workflow roda automaticamente em push no branch main e manual via “Run workflow”.
- Artefatos publicados:
  - libgdx-libs → pacote único
  - libgdx-individual → pacotes individuais + relatórios por lib
  - libgdx-reports → relatório geral (libs-report.txt)

Você pode baixar os artefatos pela aba “Actions” > execução do workflow > “Artifacts”.

---

Relatórios e diagnóstico

- Status por dependência:
  - SUCESSO: arquivo presente e copiado
  - NÃO ENCONTRADA: artefato não resolvido pelo Gradle
  - FALHA NO DOWNLOAD: erro durante cópia/acesso

Dicas:
- Falhas intermitentes: reexecute com --refresh-dependencies.
- Rede lenta/instável: considere um mirror (Nexus/Artifactory) se necessário.
- Versões: atualize no build.gradle se precisar testar outras releases.

---

Personalização

- Versões: edite as versões no bloco dependencies do build.gradle.
- Java: ajuste java-version no gradle.yml e org.gradle.jvmargs no gradle.properties.
- Saída: altere os destinos em copyAllDependencies e nas tasks de relatório.

---
