export const PageHeader = ({ title, subtitle, action }: any) => {
  return (
    <div className="page-header">
      <div>
        <div className="eyebrow">Merchant services / Operations</div>
        <h1>{title}</h1>
        <p>{subtitle}</p>
      </div>
      {action}
    </div>
  );
}